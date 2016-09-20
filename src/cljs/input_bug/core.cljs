(ns input-bug.core
    (:require [reagent.core :as reagent :refer [atom]]))

;; -------------------------
;; Views

(defn problem-component
  []
  (let [selections (reagent/atom :a)]  ;; (second @items)
    (fn []
      [:div
       [:input
        {:type      "checkbox"
         ;:checked (some? @selections) ;; works in both
         :checked   @selections                             ;; works in 0.6.0-rc not in 0.6.0
         :on-change (fn [] (swap! selections #(if % nil :a)))}]
       (pr-str @selections)])))

(defn mount-root []
  (reagent/render [problem-component] (.getElementById js/document "app")))

(defn init! []
  (mount-root))
