(defn nn [n] #(nth %1 n))

(def pattern #"#([0-9]+) @ ([0-9]+),([0-9]+): ([0-9]+)x([0-9]+)")

(def codes ["#1 @ 1,3: 4x4"
            "#2 @ 3,1: 4x4"
            "#3 @ 5,5: 2x2"])

(defn extract [s] (drop 2 (re-matches pattern s)))
(def dim-keys [:x :y :width :height])
(def parsed 
  (map #(-> (->> (extract %1) (map read-string) (zipmap keys))) codes))

(def outerBounds [
                  (apply min (map :x parsed))
                  (apply min (map :y parsed))
                  (apply max (map #(+ (:x %1) (:width %1)) parsed))
                  (apply max (map #(+ (:y %1) (:height %1)) parsed))
                  ])

