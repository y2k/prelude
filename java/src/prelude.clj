(defmacro not= [a b] (list 'not (list '= a b)))

(defmacro gen-class [& body] (list '__inject_raw_sexp (list 'gen-class* (quote body))))

(defmacro fn! [& body] (concat (list ^void 'fn) body))

(defmacro str [& xs] (concat (list 'y2k.RT/str) xs))

(defmacro checked! [f] (list 'y2k.RT/try_ (list 'fn (vector) f)))

(defmacro get [target key] (list 'y2k.RT/get target key))

(defmacro throw [e] (list 'y2k.RT/throw_ e))

(defmacro println [& xs] (concat (list 'y2k.RT/println) xs))

(defmacro js! [& body] (list 'comment body))

(defmacro jvm! [& body] (concat (list 'module) body))

(defmacro def- [k v] (list 'def ^:private k v))

(defmacro runnable [f] (list 'y2k.RT/runnable f))

(defmacro as [instance class] (list 'as* instance class))
(defmacro is [instance class] (list 'is* instance class))
(defmacro class [cls_name] (list '__inject_raw_sexp (list 'class (quote cls_name))))

(defmacro vector [& xs] (concat (list 'java.util.List/of) xs))
(defmacro hash-map [& xs] (concat (list 'java.util.Map/of) xs))

(defmacro class [cls] (list 'quote (symbol (str cls ".class"))))
(defmacro do [& xs] (concat (list 'let (vector)) xs))

;; Declarations

(def as* null)
(def get null)
(def is* null)
(def not null)
(def unit null)

;; Default java imports (FIXME)

;; (def ClassLoader null)
;; (def Object null)
(def String null)
