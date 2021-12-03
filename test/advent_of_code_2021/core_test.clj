(ns advent-of-code-2021.core-test
  (:require [clojure.test :refer :all]
            [advent-of-code-2021.day-1-sonar-sweep.sonar-sweep :as day-1]
            [advent-of-code-2021.day-2-dive.dive :as day-2]
            [advent-of-code-2021.day-3-binary-diagnostic.binary-diagnostic :as day-3]))

(deftest day-1-sonar-sweep-test
  (testing "Day 1 - Sonar Sweep"
    (let [input ["199" "200" "208" "210" "200" "207" "240" "269" "260" "263"]
          expected 7]
      (is
        (= (day-1/sonar-sweep input) expected)))))

(deftest day-1-sonar-sweep-extended-test
  (testing "Day 1 - Sonar Sweep Extended"
    (let [input ["199" "200" "208" "210" "200" "207" "240" "269" "260" "263"]
          expected 5]
      (is
        (= (day-1/sonar-sweep-extended input) expected)))))

(deftest day-2-dive-test
  (testing "Day 2 - Dive!"
    (let [input ["forward 5"
                 "down 5"
                 "forward 8"
                 "up 3"
                 "down 8"
                 "forward 2"]
          expected 150]
      (is
        (= (day-2/dive input) expected)))))

(deftest day-2-dive-extended-test
  (testing "Day 2 - Dive! Extended"
    (let [input ["forward 5"
                 "down 5"
                 "forward 8"
                 "up 3"
                 "down 8"
                 "forward 2"]
          expected 900]
      (is
        (= (day-2/dive-extended input) expected)))))

(deftest day-3-binary-diagnostic
  (testing "Day 3 - Binary Diagnostic"
    (let [input ["00100"
                 "11110"
                 "10110"
                 "10111"
                 "10101"
                 "01111"
                 "00111"
                 "11100"
                 "10000"
                 "11001"
                 "00010"
                 "01010"]
          expected 198]
      (is
        (= (day-3/binary-diagnostic input) expected)))))

(deftest day-3-binary-diagnostic-extended
  (testing "Day 3 - Binary Diagnostic Extended"
    (let [input ["00100"
                 "11110"
                 "10110"
                 "10111"
                 "10101"
                 "01111"
                 "00111"
                 "11100"
                 "10000"
                 "11001"
                 "00010"
                 "01010"]
          expected 230]
      (is
        (= (day-3/binary-diagnostic-extended input) expected)))))