(def m [-6, +3, +8, +5, -6])
(def c (count m))

(loop [resSet #{} running 0 ind 0]
  (if (contains? resSet running)
    running
    (recur (conj resSet running)
           (+ running (get m ind))
           (mod (inc ind) c))))