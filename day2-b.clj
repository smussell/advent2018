(def m (cycle [-6, +3, +8, +5, -6]))

(loop [resSet #{} running 0 ind 0]
  (if (contains? resSet running)
    running
    (recur (conj resSet running)
           (+ running (nth m ind))
           (inc ind))))
