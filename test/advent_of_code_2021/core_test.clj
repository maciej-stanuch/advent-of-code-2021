(ns advent-of-code-2021.core-test
  (:require [clojure.test :refer :all]
            [advent-of-code-2021.day-1-sonar-sweep.sonar-sweep :as day-1]
            [advent-of-code-2021.day-2-dive.dive :as day-2]))

(deftest day-1-sonar-sweep-test
  (testing "Day 1 - Sonar Sweep"
    (let [input ["199" "200" "208" "210" "200" "207" "240" "269" "260" "263"]
          expected 7]
      (is
        (= expected (day-1/sonar-sweep input))))))

(deftest day-1-sonar-sweep-extended-test
  (testing "Day 1 - Sonar Sweep Extended"
    (let [input ["199" "200" "208" "210" "200" "207" "240" "269" "260" "263"]
          expected 5]
      (is
        (= expected (day-1/sonar-sweep-extended input))))))

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
        (= expected (day-2/dive input))))))

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
        (= expected (day-2/dive-extended input))))))