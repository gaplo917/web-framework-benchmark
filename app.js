const Koa = require('koa');
const app = new Koa();
app.use(async ctx => {
  ctx.body = 'OK';
});
app.listen(8080);
