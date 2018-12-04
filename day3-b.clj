(defn nn [n] #(nth %1 n))

(def pattern #"#([0-9]+) @ ([0-9]+),([0-9]+): ([0-9]+)x([0-9]+)")

(def codes ["#1 @ 1,3: 4x4"
            "#2 @ 3,1: 4x4"
            "#3 @ 5,5: 2x2"])

(defn extract [s] (drop 1 (re-matches pattern s)))
(def dim-keys [:i :x :y :width :height])

(def parsed
  (map #(->> (extract %1)
             (map read-string)
             (zipmap dim-keys))
       codes))

(defn get-squares [{:keys [x y width height]}]
  (for [i (range width) j (range height)]
    [(+ x i) (+ y j)]))

(defn update-grid [grid box]
  (->>
   (get-squares box)
   (reduce #(assoc %1 %2 (inc (get %1 %2 0))) grid)))

(def grid (reduce update-grid {} parsed))

(filter (fn [box] (every? #(= 1 (get grid %1)) (get-squares box))) parsed)
