;; JS prelude
;; (def quote 0)
(def __raw_template 0)
(def . 0)
(def assoc 0)
(def catch 0)
(def comment 0)
(def do 0)
(def false 0)
(def fn* 0)
(def hash-map 0)
(def let* 0)
(def new 0)
(def ns 0)
(def null 0)
(def set 0)
(def set! 0)
(def spread 0)
(def true 0)
(def try 0)
(def vector 0)
(def while 0)

(defmacro FIXME [& args]
  (list 'throw
        (list 'Error.
              (concat
               (list
                'str
                (str "FIXME " __FILENAME__ ":" __LINE__ ":" (- __POSITION__ 1) " - "))
               args))))

(defmacro def- [k v] (list 'def ^:private k v))
(defmacro do [& body] (concat (list 'let (vector)) body))
(defmacro eprintln [& args] (concat (list '.error 'console) args))
(defmacro first [xs] (list 'get (list '.from 'Array xs) 0))
(defmacro js! [& body] (concat (list 'do) body))
(defmacro jvm! [& body] (list 'comment body))
(defmacro not= [a b] (list 'not (list '= a b)))
(defmacro println [& args] (concat (list '.info 'console) args))
(defmacro rest [xs] (list '.toSpliced (list '.from 'Array xs) 0 1))
(defmacro second [xs] (list 'get (list '.from 'Array xs) 1))
(defmacro str [& args] (concat (list '+ "") args))
(defmacro some? [x] (list 'not (list 'nil? x)))
(defmacro string? [x] (list '= :string (list 'type x)))
(defmacro number? [x] (list '= :number (list 'type x)))
(defmacro seq? [x] (list 'Array.isArray x))
(defmacro map? [x] (list '__raw_template "(" x " instanceof Map)"))
;; (defmacro reduce [xs f init] (list '.reduce xs f init))
(defmacro reduce [xs f init]
  (list '__raw_template
        "(function() {
          const xs=" xs ";
          const f=" f ";
          const init=" init ";
          if (Array.isArray(xs)){return xs.reduce(f,init)}
          else{return Object.entries(xs).reduce(f,init)}})()"))

(defmacro atom [x] (vector x))
(defmacro deref [x] (list 'get x 0))
(defmacro reset! [a x] (list 'do (list '.fill a x) x))
(defmacro swap! [a f] (list 'get (list '.splice a 0 1 (list f (list 'get a 0))) 0))

(defmacro empty? [xs] (list '= 0 (list '.-length xs)))

(def concat 0)
(def list 0)
(def transform_nodes 0)

(defn- make_operator [sep xs]
  (concat
   (list '__raw_template "(")
   (transform_nodes {:sep sep} xs)
   (list ")")))

(defmacro - [& xs] (make_operator " - " xs))
(defmacro * [& xs] (make_operator " * " xs))
(defmacro + [& xs] (make_operator " + " xs))
(defmacro and [& xs] (make_operator " && " xs))
(defmacro or [& xs] (make_operator " || " xs))

(defmacro / [a b] (list '__raw_template "(" a " / " b ")"))
(defmacro % [a b] (list '__raw_template "(" a " % " b ")"))
(defmacro < [a b] (list '__raw_template "(" a " < " b ")"))
(defmacro <= [a b] (list '__raw_template "(" a " <= " b ")"))
(defmacro = [a b] (list '__raw_template "" a " === " b))
(defmacro > [a b] (list '__raw_template "(" a " > " b ")"))
(defmacro >= [a b] (list '__raw_template "(" a " >= " b ")"))
(defmacro assoc! [col key value] (list '__raw_template "" col "[" key "]=" value))
(defmacro concat [a b] (list '__raw_template "[..." a ", ..." b "]"))
(defmacro conj [a b] (list '__raw_template "[..." a ", " b "]"))
(defmacro cons [a b] (list '__raw_template "[" a ", ..." b "]"))
(defmacro export-default [body] (list '__raw_template "export default " body))
(defmacro get [target index] (list '__raw_template "" target "[" index "]"))
;; (defmacro if [c a b] (list '__raw_template "(" c " ? " a " : " b ")"))
(defmacro merge [a b] (list '__raw_template "{ ..." a ", ..." b " }"))
(defmacro nil? [x] (list 'or (list '= 'null x) (list '= 'undefined x)))
(defmacro not [x] (list '__raw_template "!(" x ")"))
;; (defmacro set! [target value] (list '__raw_template "(" target " = " value ");"))
;; (defmacro spread [a] (list '__raw_template "..." a))
(defmacro throw [ex] (list '__raw_template "(function(){throw " ex "})()"))
(defmacro type [x] (list '__raw_template "typeof " x))

;; (defmacro quote [n]
;;   {:__y2k_type :quote
;;    :value (str n)})

(defmacro quote_of_string [n]
  {:__y2k_type :quote
   :value n})

(defmacro quote? [x]
  (list '= :quote (list '.-__y2k_type x)))

;; (defmacro vector [& args]
;;   (concat
;;    (list '__raw_template "[")
;;    (transform_nodes {:sep ","} args)
;;    (list "]")))

(defmacro list [& args]
  (list 'let ['xs (concat (list 'vector) args)]
        (list 'set! (list '.-__y2k_type 'xs) :list)
        'xs))

(defmacro list? [x]
  (list '= :list (list '.-__y2k_type x)))

;; HTML
(def alert 0)
(def Array 0)
(def BarcodeDetector 0)
(def Buffer 0)
(def console 0)
(def createImageBitmap 0)
(def crypto 0)
(def Date 0)
(def debugger 0)
(def document 0)
(def Error 0)
(def eval 0)
(def fetch 0)
(def globalThis 0)
(def JSON 0)
(def localStorage 0)
(def Math 0)
(def Object 0)
(def parseInt 0)
(def process 0)
(def Promise 0)
(def RegExp 0)
(def Response 0)
(def setTimeout 0)
(def undefined 0)
(def window 0)

;; Debug

(defmacro DEBUG [message value]
  (list 'do
        (list 'eprintln message value)
        value))
