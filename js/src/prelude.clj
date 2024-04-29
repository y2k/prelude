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

(defmacro atom [x] (list 'RT/atom x))
(defmacro deref [x] (list 'RT/deref x))
(defmacro reset! [a x] (list 'RT/reset a x))
(defmacro swap! [a f] (list 'RT/swap a f))

(defmacro not= [a b] (list 'not (list '= a b)))

;; JS prelude
(def __unsafe_insert_js null)
(def and null)
(def assoc null)
(def assoc! null)
(def set! null)
(def get null)
(def type null)
(def comment null)
(def concat null)
(def conj null)
(def export-default null)
(def hash-map null)
(def merge null)
(def not null)
(def or null)
(def spread null)
(def vector null)

;; HTML
(def console null)
