import home from './views/Home'
import book from './views/book/Book'

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
}]
