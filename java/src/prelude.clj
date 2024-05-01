(defmacro not= [a b] (list 'not (list '= a b)))

(defmacro gen-class [& body] (list '__inject_raw_sexp (list 'gen-class* (quote body))))

(defmacro fn! [& body] (concat (list ^void 'fn) body))

(defmacro str [& xs] (concat (list 'y2k.RT/str) xs))

(defmacro checked! [f] (list 'y2k.RT/try_ (list 'fn (vector) f)))

(defmacro get [target key] (list 'y2k.RT/get target key))

(defmacro throw [e] (list 'y2k.RT/throw_ e))

(defmacro println [& xs] (list 'do (concat (list 'y2k.RT/println) xs)))

(defmacro js! [& body] (list 'comment body))

(defmacro jvm! [& body] (concat (list 'module) body))

(defmacro def- [k v] (list 'def ^:private k v))

(defmacro runnable [f] (list 'y2k.RT/runnable f))

(defmacro is [instance class] (list '__inject_raw_sexp (list 'is instance (quote class))))
(defmacro as [instance class] (list '__inject_raw_sexp (list 'as instance (quote class))))
(defmacro class [cls_name] (list '__inject_raw_sexp (list 'class (quote cls_name))))

;; Declarations

(def as null)
(def class null)
(def gen-class* null)
(def get null)
(def hash-map null)
(def is null)
(def not null)
(def vector null)

;; Default java imports (FIXME)

(def ClassLoader null)
(def Object null)
(def String null)
