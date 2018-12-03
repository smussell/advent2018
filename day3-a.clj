(defn nn [n] #(nth %1 n))

(def pattern #"#([0-9]+) @ ([0-9]+),([0-9]+): ([0-9]+)x([0-9]+)")

(def codes ["#1 @ 1,3: 4x4"
            "#2 @ 3,1: 4x4"
            "#3 @ 5,5: 2x2"])

(defn extract [s] (drop 2 (re-matches pattern s)))
(def parsed 
  (map #(map read-string (extract %1)) codes))

(def outerBounds [
                  (apply min (map (nn 0) parsed))
                  (apply min (map (nn 1) parsed))
                  (apply max (map #(+ (nth %1 0) (nth %1 2)) parsed))
                  (apply max (map #(+ (nth %1 1) (nth %1 3)) parsed))
                  ])

