<template>
  <div id="exampleView">
    <CodeEditor :value="codeValue" :handle-change="onCodechange" />
    <hr />
    <MdEditor :value="mdValue" :handle-change="onMdchange" />
  </div>
</template>

<script setup lang="ts">
import { ref } from "vue";
import MdEditor from "@/components/MdEditor.vue";
import CodeEditor from "@/components/CodeEditor.vue";

const mdValue = ref();
const codeValue = ref();

const onMdchange = (v: string) => {
  mdValue.value = v;
};

const onCodechange = (v: string) => {
  codeValue.value = v;
};
</script>
