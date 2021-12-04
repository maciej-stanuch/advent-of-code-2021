(ns advent-of-code-2021.core
  (:gen-class)
  (:require
    [advent-of-code-2021.day-1-sonar-sweep.sonar-sweep :as day-1]
    [advent-of-code-2021.day-2-dive.dive :as day-2]
    [advent-of-code-2021.day-3-binary-diagnostic.binary-diagnostic :as day-3]))

(def day-result-pairs [["Day 1 - Sonar Sweep"
                        (day-1/sonar-sweep day-1/input)]
                       ["Day 1 - Sonar Sweep Extended"
                        (day-1/sonar-sweep-extended day-1/input-extended)]
                       ["Day 2 - Dive!"
                        (day-2/dive day-2/input)]
                       ["Day 2 - Dive! Extended"
                        (day-2/dive-extended day-2/input)]
                       ;["Day 3 - Binary Diagnostics"
                       ; (day-3/binary-diagnostic day-3/input)]
                       ["Day 3 - Binary Diagnostics Extended"
                        (day-3/binary-diagnostic-extended day-3/input)]])

(defn -main
  [& _]
  (println "===== Advent of Code 2021 =====")
  (doseq [pair day-result-pairs]
    (println (first pair))
    (println (second pair))))
