<template>
    <div id="app">
        <div>主页</div>
        <br/>
        <!-- 路由出口 -->
        <!-- 路由匹配到的组件将渲染在这里 -->
        <router-link to="/book">图书收藏</router-link>
        <router-link to="/search">查询图书</router-link>
        <router-link to="/classifyBook">图书分类</router-link>
    </div>
</template>
