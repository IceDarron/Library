<template>
  <div title="图书收藏">
    <!-- top  -->
    <div class="head">图书收藏</div>
    <div class="top">
      <div class="search">
          <div>书籍名称： <input v-model="c_BOOKNAME" /></div>
          <div>作者： <input v-model="c_AUTHOR" /></div>
          <div>出版社：<input v-model="c_PUBLISHER" /></div>
      </div>
      <button @click="getBookByCondition(0)">搜索书籍</button>
      <button @click="getBookAll()">获取所有书籍</button>
      <!-- <button @click="getBookClassification()">获取所有书籍分类</button> -->
     <button @click="addBook()">新增书籍</button>
   </div>

   <!-- left  -->
    <div class="left">
      <div class="book-classify" v-for="(item, i) in bookClassifys">
        <div class="col" @click="getBookByCondition(item)">
          <div class="inline">类型名称：
            <span>{{item.c_Name}}</span>
          </div>
        </div>
        <div class="col">
          <div class="inline">数量：
            <span>{{item.number}}</span>
          </div>
        </div>
      </div>
    </div>
    <!-- right  -->
    <div class="right">
     <div class="book-show" v-for="(item, i) in books">
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
        <button class="delete" @click="deleteBook(item)">删除</button>
    </div>
    </div>
    <!-- bottom  -->
    <div class="bottom">IceDarron</div>
  </div>
</template>
<script>
  import axios from 'axios'
  export default {
    created () {
      this.getBookClassification()
    },
    props: {
      c_BOOKNAME: '',
      c_AUTHOR: '',
      c_PUBLISHER: '',
      c_CATEGORY: ''
    },
    name: 'show',
    data () {
      return {
        books: [],
        bookClassifys: [],
        isA: -1
      }
    },
    methods: {
      getBookByCondition (item) {
        axios.get('/Library/getBookByCondition', {
          params: {
            c_BOOKNAME: this.c_BOOKNAME,
            c_AUTHOR: this.c_AUTHOR,
            c_PUBLISHER: this.c_PUBLISHER,
            c_CATEGORY: this.c_CATEGORY || item.c_Code
          }
        })
        .then((response) => {
          console.log(response.data)
          this.books = JSON.parse(response.data)
        })
        .catch((error) => {
          console.log(error)
        })
      },
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
      },
      getBookClassification () {
        axios.get('/Library/getBookClassification')
        .then((response) => {
          console.log(response.data)
          this.bookClassifys = JSON.parse(response.data)
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
    width: 100%;
    height:20%;
    z-index: 100;
    float: left;
}

.left {
  width: 20%;
  z-index: 100;
  float: left;
}

.right {
  width: 80%;
  z-index: 100;
  float: left;
}

.search {
    margin: 10px;
}

.bottom {
    position: fixed;
    bottom: 10px;
    width: 100%;
    z-index: 100;
}

.book-show {
  margin: 20px;
  width: 500px;
  height: 300px;
  position: relative;
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
