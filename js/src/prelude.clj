
(defmacro do [& body] (concat (list 'let (vector)) body))

(defmacro println [& args] (concat (list '.info 'console) args))
(defmacro eprintln [& args] (concat (list '.error 'console) args))

(defmacro def- [k v] (list 'def ^:private k v))

(defmacro FIXME [& args]
  (list 'throw
        (list 'Error.
              (concat
               (list
                'str
                (str "FIXME " __FILENAME__ ":" __LINE__ ":" (- __POSITION__ 1) " - "))
               args))))
(defmacro str [& args] (concat (list '+ "") args))

(defmacro jvm! [& body] (list 'comment body))

(defmacro js! [& body] (concat (list 'module) body))

(defmacro atom [x] (list '.of 'Array x))
(defmacro deref [x] (list 'get x 0))
(defmacro reset! [a x] (list 'do (list '.fill a x) x))
(defmacro swap! [a f] (list 'get (list '.splice a 0 1 (list f (list 'get a 0))) 0))

(defmacro not= [a b] (list 'not (list '= a b)))

(defmacro first [xs] (list 'get (list '.from 'Array xs) 0))
(defmacro second [xs] (list 'get (list '.from 'Array xs) 1))
(defmacro concat [a b] (list '__raw_template "[..." a ", ..." b "]"))
(defmacro conj [a b] (list '__raw_template "[..." a ", " b "]"))
(defmacro spread [a] (list '__raw_template "..." a))
(defmacro merge [a b] (list '__raw_template "{ ..." a ", ..." b " }"))
(defmacro assoc! [col key value] (list '__raw_template "" col "[" key "]=" value))
(defmacro throw [ex] (list '__raw_template "(function(){throw " ex "})()"))
(defmacro type [x] (list '__raw_template "typeof " x))
(defmacro set! [target value] (list '__raw_template "(" target " = " value ");"))
(defmacro < [a b] (list '__raw_template "(" a " < " b ")"))
(defmacro > [a b] (list '__raw_template "(" a " > " b ")"))
(defmacro <= [a b] (list '__raw_template "(" a " <= " b ")"))
(defmacro >= [a b] (list '__raw_template "(" a " >= " b ")"))

;; JS prelude
(def __raw_template 0)
(def __unsafe_insert_js 0)
(def - 0)
(def . 0)
(def * 0)
(def / 0)
(def % 0)
(def + 0)
(def = 0)
(def alert 0)
(def and 0)
(def assoc 0)
(def catch 0)
(def comment 0)
(def do 0)
(def export-default 0)
(def false 0)
(def fn* 0)
(def get 0)
(def hash-map 0)
(def if 0)
(def let* 0)
(def new 0)
(def not 0)
(def null 0)
(def or 0)
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
