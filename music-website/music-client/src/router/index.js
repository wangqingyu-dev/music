const router = {
  routes: [
    {
      path: '*',
      redirect: '/404'
    },
    {
      path: '/404',
      component: () => import('@/pages/404.vue')
    },
    {
      path: '/login-in',
      name: 'login-in',
      // component: () => import('@/pages/LoginIn'),
      component: resolve => require(['@/pages/LoginIn'],resolve),
    },
    {
      path: '/sign-up',
      name: 'sign-up',
      component: resolve => require(['@/pages/SignUp'],resolve)
    },
    {
      path: '/',
      name: 'home',
      component: resolve => require(['@/pages/Home'],resolve)
    },
    {
      path: '/song-list',
      name: 'song-list',
      component: resolve => require(['@/pages/SongList'],resolve)
    },
    {
      path: '/my-music',
      name: 'my-music',
      component: resolve => require(['@/pages/MyMusic'],resolve)
    },
    {
      path: '/song-list-album/:id',
      name: 'song-list-album',
      component: resolve => require(['@/pages/SongListAlbum'],resolve)
    },
    {
      path: '/singer',
      name: 'singer',
      component: resolve => require(['@/pages/Singer'],resolve)
    },
    {
      path: '/singer-album/:id',
      name: 'singer-album',
      component: resolve => require(['@/pages/SingerAlbum'],resolve)
    },
    {
      path: '/lyric/:id',
      name: 'lyric',
      component: resolve => require(['@/pages/Lyric'],resolve)
    },
    {
      path: '/search',
      name: 'search',
      component: resolve => require(['@/pages/Search'],resolve)
    },
    {
      path: '/setting',
      name: 'setting',
      component: resolve => require(['@/pages/Setting'],resolve)
    }
  ],
  scrollBehavior(to, from, savedPosition) {
    return { x: 0, y: 0 }
  }
}

export default router
