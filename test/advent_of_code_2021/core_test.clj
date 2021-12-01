(ns advent-of-code-2021.core-test
  (:require [clojure.test :refer :all]
            [advent-of-code-2021.day-1-sonar-sweep.sonar-sweep :as day-1]))

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
