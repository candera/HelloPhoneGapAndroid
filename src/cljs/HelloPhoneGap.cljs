(ns HelloPhoneGap)

(defn ^:export hello [name]
  (js/alert (str "Hello, " name)))

(defn ^:export start []
  (js/alert "Started!"))