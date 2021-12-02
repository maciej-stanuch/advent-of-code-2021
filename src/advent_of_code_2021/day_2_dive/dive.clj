(ns advent-of-code-2021.day-2-dive.dive
  (:use advent-of-code-2021.utils)
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))

(def input (read-file (io/resource "day-2-dive.txt")))

(defn execute-command-with-aim
  [[command parameter] current-state]
  (let [param (Integer/parseInt parameter)]
    (case command
      "forward" (-> (update current-state :horizontal + param)
                    (update :depth + (* (:aim current-state) param)))
      "down" (update current-state :aim + param)
      "up" (update current-state :aim - param))))

(defn execute-command-without-aim
  [[command parameter] current-state]
  (let [param (Integer/parseInt parameter)]
    (case command
      "forward" (update current-state :horizontal + param)
      "down" (update current-state :depth + param)
      "up" (update current-state :depth - param))))

(defn calculate-final-state
  ([commands starting-state]
   (calculate-final-state commands starting-state execute-command-with-aim))
  ([commands starting-state command-execute-function]
   (if (empty? commands)
     starting-state
     (let [next-state (command-execute-function (first commands) starting-state)]
       (calculate-final-state (rest commands) next-state command-execute-function)))))

(defn dive [input]
  (let [commands (map #(str/split % #" ") input)
        starting-state {:horizontal 0
                        :depth      0
                        :aim        0}
        final-state (calculate-final-state
                      commands
                      starting-state
                      execute-command-without-aim)]
    (* (:horizontal final-state) (:depth final-state))))

(defn dive-extended [input]
  (let [commands (map #(str/split % #" ") input)
        starting-state {:horizontal 0
                        :depth      0
                        :aim        0}
        final-state (calculate-final-state
                      commands
                      starting-state
                      execute-command-with-aim)]
    (* (:horizontal final-state) (:depth final-state))))