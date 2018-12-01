(def m (cycle [-6, +3, +8, +5, -6]))

(loop [resSet #{} running 0 list m]
  (if (contains? resSet running)
    running
    (recur (conj resSet running)
           (+ running (first list))
           (next list))))
