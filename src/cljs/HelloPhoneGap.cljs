(ns HelloPhoneGap
  [:use [goog.dom :only (getElement setTextContent)]
   [goog.events :only (listen EventType)]]
  )

(defn ^:export hello [name]
  (js/alert (str "Hello, " name)))


(defn ->js
  "Convert an object to its Javascript equivalent"
  [o]
  (cond
    (keyword? o) (name o)
    (map? o) (let [out (js-obj)]
               (doseq [[k v] o]
                 (aset out (->js k) (->js v)))
               out)
    (coll? o) (apply array (map ->js o))
    :else o))

(defn- set-text! [id text]
  (.setTextContent (.getElement js/document id) (str text)))

(defn- accelerometer-success [acceleration]
  (doseq [prop ["x" "y" "z"]]
    (set-text! (str "acc-" prop) (aget acceleration prop)))
  (set-text! "acc-t" (.-timestamp acceleration)))

(defn- accelerometer-error []
  (.log js/console "accelerometer error"))

(defn watch-acceleration []
 (.watchAcceleration (.-accelerometer js/navigator)
                     accelerometer-success
                     accelerometer-error
                     (->js {:frequency 3000})))
(defn ^:export start []
  (listen js/document "deviceready" watch-acceleration))