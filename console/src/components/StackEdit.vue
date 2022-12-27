<script lang="ts" setup>
import { computed, ref } from "vue";

const props = defineProps({
  raw: {
    type: String,
    required: false,
    default: "",
  },
  content: {
    type: String,
    required: false,
    default: "",
  },
});

const emit = defineEmits<{
  (event: "update:raw", value: string): void;
  (event: "update:content", value: string): void;
  (event: "update", value: string): void;
}>();

const url = "https://stackedit.io/app";

const iframeRef = ref<HTMLIFrameElement>();

const urlParser = computed(() => {
  const params = {
    origin: `${window.location.protocol}//${window.location.host}`,
    fileName: "",
    contentText: props.raw,
    silent: false,
  };

  const a = document.createElement("a");
  a.href = url;

  const serializedParams = Object.keys(params)
    .map((key) => `${key}=${encodeURIComponent(params[key] || "")}`)
    .join("&");
  a.hash = `#${serializedParams}`;

  return a;
});

const $origin = computed(() => {
  return `${urlParser.value.protocol}//${urlParser.value.host}`;
});

function messageHandler(event: MessageEvent) {
  if (
    event.origin === $origin.value &&
    event.source === iframeRef.value?.contentWindow
  ) {
    switch (event.data.type) {
      case "fileChange":
        emit("update:raw", event.data.payload.content.text);
        emit("update:content", event.data.payload.content.html);
        emit("update", event.data.payload.content.text);
        break;
    }
  }
}

window.addEventListener("message", messageHandler);
</script>

<template>
  <div class="h-full border-none">
    <iframe
      ref="iframeRef"
      class="h-full w-full border-none"
      :src="urlParser.href"
    ></iframe>
  </div>
</template>
