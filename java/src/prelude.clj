;; Common

(defmacro FIXME [& args]
  (list 'throw
        (list 'Exception.
              (concat
               (list
                'str
                (str "FIXME " __FILENAME__ ":" __LINE__ ":" (- __POSITION__ 1) " - "))
               args))))

;; Collections

(defmacro map? [x] (list 'is x "java.util.Map"))
(defmacro list? [x] (list 'is x "java.util.LinkedList"))
(defmacro vector? [x] (list 'is x "java.util.ArrayList"))

(defmacro list [& xs] (list 'java.util.LinkedList. (concat (list 'java.util.Arrays/asList) xs)))
(defmacro vec [xs] (list 'java.util.Arrays/asList xs))

(defmacro first [xs] (list 'get xs 0))
(defmacro second [xs] (list 'get xs 1))

;; Other

(defmacro = [a b] (list 'call-runtime ''equals a b))
(defmacro def- [k v] (list 'def ^:private k v))
(defmacro do [& xs] (concat (list 'let (vector)) xs))
(defmacro get [target key] (list 'call-runtime ''get target key))
(defmacro into-array [xs] (list 'call-runtime ''into_array xs))
(defmacro into-array2 [type xs] (list 'call-runtime ''into_array type xs))
(defmacro js! [& body] (list 'comment body))
(defmacro jvm! [& body] (concat (list 'do) body))
(defmacro not= [a b] (list 'not (list '= a b)))
(defmacro println [& xs] (concat (list 'call-runtime ''println) xs))
(defmacro str [& xs] (concat (list 'call-runtime ''str) xs))
(defmacro throw [e] (list 'call-runtime ''throw_ e))

(defmacro atom [x] (list 'java.util.concurrent.atomic.AtomicReference. x))
(defmacro deref [a] (list '.get (list 'as a "java.util.concurrent.atomic.AtomicReference<Object>")))
(defmacro reset! [a x] (list '.set (list 'as a "java.util.concurrent.atomic.AtomicReference<Object>") x))

;; Java interop

(defmacro assoc [xs k v] (list 'call-runtime ''assoc xs k v))
(defmacro checked! [f] (list 'call-runtime ''try_ (list 'fn (vector) f)))
(defmacro class [cls] (list 'class-inner (list 'quote (symbol (str cls ".class")))))
(defmacro concat [as bs] (list 'call-runtime ''concat as bs))
(defmacro conj [xs x] (list 'call-runtime ''conj xs x))
(defmacro count [xs] (list 'call-runtime ''count xs))
(defmacro declare [name] (list 'def name))
(defmacro empty? [xs] (list 'call-runtime ''empty xs))
(defmacro fn! [& body] (concat (list ^void 'fn) body))
(defmacro function [f] (list 'call-runtime ''function f))
(defmacro gen-class [& body] (list 'gen-class-inner (list 'quote body)))
(defmacro merge [as bs] (list 'call-runtime ''merge as bs))
(defmacro nil? [x] (list '= 'null x))
(defmacro rest [xs] (list 'call-runtime ''rest xs))
(defmacro runnable [f] (list 'call-runtime ''runnable f))

;; Declarations

(def - 0)
(def . 0)
(def * 0)
(def / 0)
(def % 0)
(def + 0)
(def < 0)
(def <= 0)
(def = 0)
(def > 0)
(def >= 0)
(def as 0)
(def call-runtime 0)
(def catch 0)
(def class-inner 0)
(def do 0)
(def false 0)
(def fn* 0)
(def gen-class-inner 0)
(def gen-class* 0)
(def get 0)
(def hash-map 0)
(def if 0)
(def is 0)
(def let* 0)
(def new 0)
(def not 0)
(def ns 0)
(def null 0)
(def quote 0)
(def set! 0)
(def throw 0)
(def true 0)
(def try 0)
(def unit 0)
(def vector 0)
(def while 0)

;; Declarations Java

(def Object 0)
(def String 0)
(def int 0)
(def boolean 0)
