(def * 0)
(def + 0)
(def = 0)
(def concat 0)
(def false 0)
(def if 0)
(def list 0)
(def str 0)
(def true 0)
(def vector 0)

(defmacro not= [a b] (list 'not (list '= a b)))

(defn not [x] (if x false true))
