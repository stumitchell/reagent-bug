(ns input-bug.core
    (:require [reagent.core :as reagent :refer [atom]]))

;; -------------------------
;; Views

(defn problem-component
  []
  (let [selections (reagent/atom :a)]  ;; (second @items)
    (fn []
      [:div
       [:div "This app shows a regression between 0.6.0-rc and 0.6.0"]
       [:div "Checkbox now does not handle transitons to nil"]
       [:div "The text next to the checkbox shows the value of :checked"]
       [:div "both checkboxes are connected to the same atom"]
       [:div "The below checkbox works in 0.6.0-rc (and before) not in 0.6.0"]
       [:input
        {:type      "checkbox"
         :checked   @selections                             ;; works in 0.6.0-rc not in 0.6.0
         :on-change (fn [] (swap! selections #(if % nil :a)))}]
       (pr-str @selections)
       [:div "The below checkbox works in both 0.6.0-rc and 0.6.0"]
       [:input
        {:type      "checkbox"
         :checked (some? @selections) ;; works in both
         :on-change (fn [] (swap! selections #(if % nil :a)))}]
       (pr-str @selections)])))

(defn mount-root []
  (reagent/render [problem-component] (.getElementById js/document "app")))

(defn init! []
  (mount-root))
