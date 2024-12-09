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

(defmacro map? [x] (list 'is x 'java.util.Map))
(defmacro list? [x] (list 'is x 'java.util.LinkedList))
(defmacro vector? [x] (list 'is x 'java.util.ArrayList))

(defmacro vector [& xs] (concat (list 'java.util.Arrays.asList) xs))
(defmacro list [& xs] (list 'java.util.LinkedList. (concat (list 'java.util.Arrays.asList) xs)))

(defmacro first [xs] (list 'get xs 0))
(defmacro second [xs] (list 'get xs 1))
(defmacro rest [xs]
  (list '.subList
        (list 'as xs 'java.util.List)
        1
        (list '.size (list 'as xs 'java.util.List))))

;; Other

(defmacro = [a b] (list 'java.util.Objects/equals a b))
(defmacro def- [k v] (list 'def ^:private k v))
(defmacro do [& xs] (concat (list 'let (vector)) xs))
(defmacro get [target key] (list 'y2k.RT/get target key))
(defmacro into-array [xs] (list 'y2k.RT/into_array xs))
(defmacro into-array2 [type xs] (list 'y2k.RT/into_array type xs))
(defmacro is [instance class] (list 'is* instance class))
(defmacro js! [& body] (list 'comment body))
(defmacro jvm! [& body] (concat (list 'do) body))
(defmacro not= [a b] (list 'not (list '= a b)))
(defmacro println [& xs] (concat (list 'y2k.RT/println) xs))
(defmacro str [& xs] (concat (list 'y2k.RT/str) xs))
(defmacro throw [e] (list 'y2k.RT/throw_ e))

(defmacro atom [x] (list 'java.util.concurrent.atomic.AtomicReference. x))
(defmacro deref [a] (list '.get (list 'as a "java.util.concurrent.atomic.AtomicReference<Object>")))
(defmacro reset! [a x] (list '.set (list 'as a "java.util.concurrent.atomic.AtomicReference<Object>") x))

;; Java interop

(defmacro as [instance class] (list 'as* instance class))
(defmacro assoc [xs k v] (list 'y2k.RT/assoc xs k v))
(defmacro checked! [f] (list 'y2k.RT/try_ (list 'fn (vector) f)))
(defmacro concat [as bs] (list 'y2k.RT/concat as bs))
(defmacro conj [xs x] (list 'y2k.RT/conj xs x))
(defmacro empty? [xs] (list 'y2k.RT/empty xs))
(defmacro fn! [& body] (concat (list ^void 'fn) body))
(defmacro gen-class [& body] (list '__inject_raw_sexp (list 'gen-class* (list 'quote body))))
(defmacro merge [as bs] (list 'y2k.RT/merge as bs))
(defmacro count [xs] (list 'y2k.RT/count xs))
(defmacro hash-map [& xs] (concat (list 'y2k.RT/hash_map) xs))
(defmacro nil? [x] (list '= 'null x))

(defmacro runnable [f] (list 'y2k.RT/runnable f))
(defmacro function [f] (list 'y2k.RT/function f))

;; (defmacro class [cls_name] (list '__inject_raw_sexp (list 'class (quote cls_name))))
(defmacro class [cls] (list 'quote (symbol (str cls ".class"))))

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
(def as* 0)
(def catch 0)
(def do 0)
(def false 0)
(def fn* 0)
(def gen-class* 0)
(def get 0)
(def if 0)
(def is* 0)
(def let* 0)
(def new 0)
(def not 0)
(def null 0)
(def quote 0)
(def set! 0)
(def throw 0)
(def true 0)
(def try 0)
(def unit 0)
(def while 0)

;; Declarations Java

;; (def ClassLoader 0)
;; (def Object 0)
(def String 0)
