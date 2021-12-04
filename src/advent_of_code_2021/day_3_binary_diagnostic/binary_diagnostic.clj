(ns advent-of-code-2021.day-3-binary-diagnostic.binary-diagnostic
  (:use advent-of-code-2021.utils)
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))

(def input (read-file (io/resource "day-3-binary-diagnostic.txt")))

(defn- transpose [m]
  (apply mapv vector m))

(defn- digits-frequency
  "Returns pairs of digits and occurrences sorted by occurrences number."
  [digit-seq]
  (let [freqs (frequencies digit-seq)]
    (reverse (sort-by second (vec freqs)))))

(defn binary-diagnostic
  [input]
  (let [binary-rates (->> (transpose input)
                          (map digits-frequency)
                          (map
                            (fn [[most-common least-common]]
                              [(first most-common) (first least-common)]))
                          (transpose)
                          (map str/join))]
    (->> (map #(Integer/parseInt % 2) binary-rates)
         (reduce *))))

(defn- oxygen-generator-filter
  [first-digits-freq bin-num]
  (let [even-number-of-digits? (and
                                 (not=
                                   (first (first first-digits-freq))
                                   (first (last first-digits-freq)))
                                 (=
                                   (second (first first-digits-freq))
                                   (second (last first-digits-freq))))]
    (if even-number-of-digits?
      (= (first bin-num) \1)
      (= (first bin-num) (first (first first-digits-freq))))))

(defn- co2-scrubber-filter
  [first-digits-freq bin-num]
  (let [even-number-of-digits? (and
                                 (not=
                                   (first (first first-digits-freq))
                                   (first (last first-digits-freq)))
                                 (=
                                   (second (first first-digits-freq))
                                   (second (last first-digits-freq))))]
    (if even-number-of-digits?
      (= (first bin-num) \0)
      (= (first bin-num) (first (last first-digits-freq))))))

(defn- find-rating-by-bit-criteria
  [num-seq criteria-filter]
  (let [digits-occurrences (->> (transpose num-seq)
                                (first)
                                (digits-frequency))
        filtered-numbers (filter #(criteria-filter digits-occurrences %) num-seq)
        first-digits (map first filtered-numbers)
        rest-digits (remove str/blank? (map #(str/join (rest %)) filtered-numbers))]
    (if (empty? rest-digits)
      first-digits
      (let [rating-by-lower-bit-criteria (find-rating-by-bit-criteria
                                           rest-digits
                                           criteria-filter)]
        (map str
             first-digits
             rating-by-lower-bit-criteria)))))

(defn binary-diagnostic-extended
  [input]
  (let [oxygen-generator-rating (first (find-rating-by-bit-criteria input oxygen-generator-filter))
        co2-scrubber-rating (first (find-rating-by-bit-criteria input co2-scrubber-filter))]
    (*
      (Integer/parseInt oxygen-generator-rating 2)
      (Integer/parseInt co2-scrubber-rating 2))))




