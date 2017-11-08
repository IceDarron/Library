<template>
  <div title="图书收藏">
    <div class="top">图书收藏</div>
    <button @click="getBookClassification()">获取所有书籍分类及数量</button>


    <div class="body">
      <div class="row" v-for="(item, i) in bookClassificatios">
        <!-- 0 -->
        <div class="col">PID：<span>{{item.c_PID}}</span></div>
        <!-- 1 -->
        <div class="col">c_Code：<span>{{item.c_Code}}</span></div>
        <!-- 2 -->
        <div class="col">分类：<span>{{item.c_Name}}</span></div>
      </div>
    </div>
    <div class="bottom">IceDarron</div>
  </div>
</template>
<script>
  import axios from 'axios'
  export default {
    name: 'show',
    data () {
      return {
        bookClassificatios: []
      }
    },
    methods: {
      getBookClassification () {
        axios.get('/Library/getBookClassification')
          .then((response) => {
            console.log(response.data)
            this.bookClassificatios = JSON.parse(response.data)
          })
          .catch((error) => {
            console.log(error)
          })
      }
    },
    computed: {
    },
    watch: {
    }
  }
</script>
<style>
  .top {
    position: fixed;
    top: 10px;
    width: 100%;
    z-index: 100;
  }

  .search {
    margin: 10px;
  }

  .body {
    margin: 10px;
  }

  .bottom {
    position: fixed;
    bottom: 10px;
    width: 100%;
    z-index: 100;
  }

  .row {
    margin: 20px;
    width: 500px;
    height: 300px;
    position: relative;
    float:left;
  }

  .col {

  }

  .inline {
    display:inline;
  }

  .delete {
    position: relative;;
    left: -60px;
  }
</style>
