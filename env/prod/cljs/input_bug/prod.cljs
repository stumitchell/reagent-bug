(ns input-bug.prod
  (:require [input-bug.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)
