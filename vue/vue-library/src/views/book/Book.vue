<template>
  <div title="图书收藏">
      <div class="top">图书收藏</div>
      <button @click="getBookAll()">获取所有书籍</button>
      <button @click="addBook()">新增书籍</button>
      <div class="body">
          <div class="row" v-for="(item, i) in books">
              <button class="delete" @click="deleteBook(item)">删除</button>
              <!-- 0 -->
              <!-- <div class="col">主键：<span>{{item.c_ID}}</span></div> -->
              <!-- 1 -->
              <!-- <div class="col">书编码：<span>{{item.c_BOOKID}}</span></div> -->
              <!-- 2 -->
              <div class="col">
                <div class="inline" @click="editBook(i + '-' + 2, item)" >书籍名称：
                  <span v-show="isA !== (i + '-' + 2)">{{item.c_BOOKNAME}}</span>
                </div>
                <div class="inline">
                  <input v-model="item.c_BOOKNAME" v-show="isA === (i + '-' + 2)">
                </div>
              </div>
              <!-- 3 -->
              <div class="col">
                <div class="inline"  @click="editBook(i + '-' + 3, item)">作者：
                  <span v-show="isA !== (i + '-' + 3)">{{item.c_AUTHOR}}</span>
                </div>
                <div class="inline">
                  <input v-model="item.c_AUTHOR" v-show="isA === (i + '-' + 3)">
                </div>
              </div>
              <!-- 4 -->
              <div class="col">
                <div class="inline"  @click="editBook(i + '-' + 4, item)">编辑者：
                  <span v-show="isA !== (i + '-' + 4)">{{item.c_EDITOR}}</span>
                </div>
                <div class="inline">
                  <input v-model="item.c_EDITOR" v-show="isA === (i + '-' + 4)">
                </div>
              </div>
              <!-- 5 -->
              <div class="col">
                <div class="inline" @click="editBook(i + '-' + 5, item)">翻译者：
                  <span v-show="isA !== (i + '-' + 5)">{{item.c_TRANSLATOR}}</span>
                </div>
                <div class="inline">
                  <input v-model="item.c_TRANSLATOR" v-show="isA === (i + '-' + 5)">
                </div>
              </div>
              <!-- 6 -->
              <div class="col">
                <div class="inline" @click="editBook(i + '-' + 6, item)">出版社：
                  <span v-show="isA !== (i + '-' + 6)">{{item.c_PUBLISHER}}</span>
                </div>
                <div class="inline">
                  <input v-model="item.c_PUBLISHER" v-show="isA === (i + '-' + 6)">
                </div>
              </div>
              <!-- 7 -->
              <div class="col">
                <div class="inline" @click="editBook(i + '-' + 7, item)">出版年：
                  <span v-show="isA !== (i + '-' + 7)">{{item.d_PUBLICATIONYEAR}}</span>
                </div>
                <div class="inline">
                  <input v-model="item.d_PUBLICATIONYEAR" v-show="isA === (i + '-' + 7)">
                </div>
              </div>
              <!-- 8 -->
              <div class="col">
                <div class="inline" @click="editBook(i + '-' + 8, item)">版本：
                  <span v-show="isA !== (i + '-' + 8)">{{item.n_VERSION}}</span>
                </div>
                <div class="inline">
                  <input v-model="item.n_VERSION" v-show="isA === (i + '-' + 8)">
                </div>
              </div>
              <!-- 9 -->
              <div class="col">
                <div class="inline" @click="editBook(i + '-' + 9, item)">第几次印刷：
                  <span v-show="isA !== (i + '-' + 9)">{{item.n_PRINTTIMES}}</span>
                </div>
                <div class="inline">
                  <input v-model="item.n_PRINTTIMES" v-show="isA === (i + '-' + 9)">
                </div>
              </div>
              <!-- 10 -->
              <div class="col">
                <div class="inline" @click="editBook(i + '-' + 10, item)">印刷数：
                  <span v-show="isA !== (i + '-' + 10)">{{item.n_PRINTNUMBER}}</span>
                </div>
                <div class="inline">
                  <input v-model="item.n_PRINTNUMBER" v-show="isA === (i + '-' + 10)">
                </div>
              </div>
              <!-- 11 -->
              <div class="col">
                <div class="inline" @click="editBook(i + '-' + 11, item)">价格：
                  <span v-show="isA !== (i + '-' + 11)">{{item.n_PRICE}}</span>
                </div>
                <div class="inline">
                  <input v-model="item.n_PRICE" v-show="isA === (i + '-' + 11)">
                </div>
              </div>
              <!-- 12 -->
              <div class="col">
                <div class="inline" @click="editBook(i + '-' + 12, item)">分类：
                  <span v-show="isA !== (i + '-' + 12)">{{item.c_CATEGORY}}</span>
                </div>
                <div class="inline">
                  <input v-model="item.c_CATEGORY" v-show="isA === (i + '-' + 12)">
                </div>
              </div>
              <!-- 13 -->
              <div class="col">
                <div class="inline" @click="editBook(i + '-' + 13, item)">描述：
                  <span v-show="isA !== (i + '-' + 13)">{{item.c_DESCRIPTION}}</span>
                </div>
                <div class="inline">
                  <input v-model="item.c_DESCRIPTION" v-show="isA === (i + '-' + 13)">
                </div>
              </div>
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
        books: [],
        isA: -1
      }
    },
    methods: {
      getBookAll () {
        axios.get('/Library/book')
        .then((response) => {
          console.log(response.data)
          this.books = JSON.parse(response.data)
        })
        .catch((error) => {
          console.log(error)
        })
      },
      editBook (cur, item) {
        if (this.isA === cur) {
          this.isA = -1
          axios.put('/Library/book/' + item.c_ID, item)
          .then(function (response) {
            console.log(response)
          })
          .catch(function (error) {
            console.log(error)
          })
        } else {
          this.isA = cur
        }
      },
      deleteBook (item) {
        axios.delete('/Library/book/' + item.c_ID, {
          params: {
            c_ID: item.c_ID
          }
        })
        .then(function (response) {
          console.log(response)
        })
        .catch(function (error) {
          console.log(error)
        })
      },
      addBook () {
        axios.post('/Library/book')
        .then(function (response) {
          console.log(response)
        })
        .catch(function (error) {
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
