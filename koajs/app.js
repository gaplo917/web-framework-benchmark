const Koa = require('koa')
const app = new Koa()
const router = require('koa-router')()

router
  .get('/', async function(ctx) {
    ctx.body = 'OK';
  })
  .get('/10ms', async function(ctx){
    await new Promise((resolve) => {
      setTimeout(resolve, 10)
    })
    ctx.body = 'OK'
  })

app.use(router.routes())

app.listen(8080)
