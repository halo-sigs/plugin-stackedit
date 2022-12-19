import { definePlugin } from "@halo-dev/console-shared";
import { markRaw } from "vue";
import StackEdit from "./components/StackEdit.vue";

export default definePlugin({
  extensionPoints: {
    "editor:create": () => {
      return [
        {
          name: "StackEdit",
          component: markRaw(StackEdit),
          rawType: "markdown",
        },
      ];
    },
  },
});
