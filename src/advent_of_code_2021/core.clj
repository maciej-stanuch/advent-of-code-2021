(ns advent-of-code-2021.core
  (:gen-class)
  (:require [advent-of-code-2021.day-1-sonar-sweep.sonar-sweep :as day-1]))

(def day-result-pairs [["Day 1 - Sonar Sweep"
                        (day-1/sonar-sweep day-1/input)]
                       ["Day 1 - Sonar Sweep Extended"
                        (day-1/sonar-sweep-extended day-1/input-extended)]])

(defn -main
  [& _]
  (println "===== Advent of Code 2021 =====")
  (doseq [pair day-result-pairs]
    (println (first pair))
    (println (second pair))))
