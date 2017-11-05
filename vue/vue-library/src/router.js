import home from './views/Home'
import book from './views/book/Book'
import search from './views/book/Search'
import classifyBook from './views/book/ClassifyBook'

export default [{
  path: '/',
  redirect: 'home'
},
{
  path: '/home',
  name: 'home',
  component: home
},
{
  path: '/book',
  name: 'book',
  component: book
},
{
  path: '/search',
  name: 'search',
  component: search
},
{
  path: '/classifyBook',
  name: 'classifyBook',
  component: classifyBook
}]
