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
(defmacro js! [& body] (concat (list 'module) body))
(defmacro jvm! [& body] (list 'comment body))
(defmacro not= [a b] (list 'not (list '= a b)))
(defmacro println [& args] (concat (list '.info 'console) args))
(defmacro rest [xs] (list '.toSpliced xs 0 1))
(defmacro second [xs] (list 'get (list '.from 'Array xs) 1))
(defmacro str [& args] (concat (list '+ "") args))
(defmacro nil? [x] (list '__raw_template "" x " == null"))
(defmacro some? [x] (list 'not (list 'nil? x)))

(defmacro atom [x] (list '.of 'Array x))
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
(defmacro export-default [body] (list '__raw_template "export default " (list 'quote body)))
(defmacro get [target index] (list '__raw_template "" target "[" index "]"))
(defmacro if [c a b] (list '__raw_template "(" c " ? " a " : " b ")"))
(defmacro merge [a b] (list '__raw_template "{ ..." a ", ..." b " }"))
(defmacro not [x] (list '__raw_template "!(" x ")"))
(defmacro set! [target value] (list '__raw_template "(" target " = " value ");"))
(defmacro spread [a] (list '__raw_template "..." a))
(defmacro throw [ex] (list '__raw_template "(function(){throw " ex "})()"))
(defmacro type [x] (list '__raw_template "typeof " x))

;; JS prelude
(def __raw_template 0)
(def . 0)
(def assoc 0)
(def catch 0)
(def comment 0)
(def do 0)
(def false 0)
(def fn* 0)
(def let* 0)
(def new 0)
(def null 0)
(def quote 0)
(def true 0)
(def try 0)
(def vector 0)
(def while 0)

;; HTML
(def alert 0)
(def Array 0)
(def Buffer 0)
(def console 0)
(def crypto 0)
(def Date 0)
(def document 0)
(def Error 0)
(def eval 0)
(def fetch 0)
(def JSON 0)
(def Math 0)
(def Object 0)
(def parseInt 0)
(def process 0)
(def Promise 0)
(def RegExp 0)
(def Response 0)
(def setTimeout 0)
(def window 0)

;; Effects
(defn- fx* [env key args]
  (let [eff (get env key)]
    (eff args)))

(defmacro fx [env key & args]
  (list 'fx* env key (vec args)))

(defmacro defn! [name args & body]
  (concat (list 'defn name (vec (concat (list '__env) args))) body))

(defmacro resolve_env [] 'env)
