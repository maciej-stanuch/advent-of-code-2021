(ns advent-of-code-2021.utils)

(defn read-file [f]
  (-> (slurp f)
      (clojure.string/split-lines)))