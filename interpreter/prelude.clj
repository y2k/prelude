(def __FILENAME__ 0)
(def __LINE__ 0)
(def __POSITION__ 0)
(def - 0)
(def * 0)
(def / 0)
(def + 0)
(def = 0)
(def concat 0)
(def count 0)
(def drop 0)
(def false 0)
(def FIXME 0)
(def get 0)
(def hash-map 0)
(def if 0)
(def list 0)
(def map 0)
(def map? 0)
(def null 0)
(def println 0)
(def reduce 0)
(def str 0)
(def true 0)
(def vec 0)
(def vector 0)
(def vector? 0)

(defmacro not= [a b] (list 'not (list '= a b)))

(defn not [x] (if x false true))
