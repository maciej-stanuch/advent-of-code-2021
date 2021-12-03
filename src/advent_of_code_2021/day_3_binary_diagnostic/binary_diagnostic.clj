(ns advent-of-code-2021.day-3-binary-diagnostic.binary-diagnostic
  (:use advent-of-code-2021.utils)
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))

(def input (read-file (io/resource "day-3-binary-diagnostic.txt")))

(defn transpose [m]
  (apply mapv vector m))

(defn digits-sorted-by-occurrences
  [digit-seq]
  (let [freqs (frequencies digit-seq)
        most-common (key (apply max-key second freqs))
        least-common (key (apply min-key second freqs))]
    [most-common least-common]))

(defn binary-diagnostic
  [input]
  (let [binary-rates (->> (transpose input)
                          (map digits-sorted-by-occurrences)
                          (transpose)
                          (map str/join))]
    (->> (map #(Integer/parseInt % 2) binary-rates)
         (reduce *))))

(defn find-rating-by-most-bit-criteria
  [input]
  (println (count input))
  (if (= (count input) 1)
    input
    (let [most-common-first-digit (->> (transpose input)
                                       (first)
                                       (digits-sorted-by-occurrences)
                                       (first))
          filtered-numbers (filter #(= (first %) most-common-first-digit) input)]
      filtered-numbers))) ;; TODO Finish it

(defn binary-diagnostic-extended
  [input]
  (println
    (find-rating-by-most-bit-criteria input)))




