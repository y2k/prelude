(defmacro not= [a b] (list 'not (list '= a b)))

(defn not [x] (if x false true))
