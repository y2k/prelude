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

(defmacro class [cls] (list 'quote (symbol (str cls ".class"))))
(defmacro do [& xs] (concat (list 'let (vector)) xs))

(defmacro = [a b] (list 'java.util.Objects/equals a b))

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
(def throw 0)
(def true 0)
(def try 0)
(def unit 0)
(def while 0)

;; Default java imports (FIXME)

;; (def ClassLoader 0)
;; (def Object 0)
(def String 0)
