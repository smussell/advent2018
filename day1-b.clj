(def input (cycle [-6, +3, +8, +5, -6]))

(loop [results #{} running 0 list input]
  (if (contains? results running)
    running
    (recur (conj results running)
           (+ running (first list))
           (next list))))
