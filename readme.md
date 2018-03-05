<h2>在线答题web项目</h2>
<h6>使用springboot+mybatis实现的在线答题web项目</h6>

<h5>功能说明:</h5><p>
分为用户端和管理端。<br/>
用户端具有注册、登录、修改密码、答题、查看答案、查看得分等功能。<br/>
管理端具有出题、判卷、查看某用户答题信息、查看某题目的答题情况等功能。<br/>
仅支持简答题类型的题目，当用户答题完成时管理员需要判卷评分，之后用户可以查看自己的得分。<br/>
用户答过的题目可以查看参考答案，如果当前题目没有作答，查看答案时会自动跳转到答题页面。</p>

<h5>技术说明:</h5><p>
后端主要使用了springboot框架、使用mybatis操作数据库、前端使用thymeleaf模板。<br/>
前端出题页面和答题页面集成了百度的UEditor编辑器但只支持文本格式的输入，不支持文件和图片上传。<br/>
使用mysql数据库，表结构和初始化数据在项目根目录下的quiz.sql中。<br/>
使用maven管理项目，利用git做版本控制。</p>

<h5>配置信息:</h5><p>
application.properties文件中以下信息可以根据自己的需要自行配置<br/>
spring.datasource.url=jdbc:mysql://localhost:3306/quizpro<br/>
spring.datasource.username=quiz<br/>
spring.datasource.password=study<br/>
spring.datasource.driver-class-name=com.mysql.jdbc.Driver<br/>
#题目列表分页时每页的条目数量<br/>
pagecount=20</p>

<h5>目前存在的缺陷:</h5><p>
如题目搜索等部分功能目前尚未完善<br/>
没有使用Spring Security 导致部分功能存在缺陷</p>

<h5>使用说明:</h5><p>
1、将源码下载后导入IDE<br/>
2、在本地mysql数据库中创建一个数据库实例并修改application.properties文件中的数据库配置<br/>
3、在将项目根目录下的quiz.sql脚本导入到当前数据库，推荐使用navicat工具如果使用其他工具报错，请自行修改sql脚本。<br/>
4、运行com.gyq.quiz.QuizApplication.java<br/>
5、在浏览器中访问localhost:8080<br/>
6、默认管理员账号为admin密码为666666，学生账号请自行注册体验。</p>

<h5>注意事项:</h5><p>
所有密码存储使用MD5加密<br/>
暂时没有添加管理员的功能，如有需求可以直接操作数据库，下一个版本中将添加此功能。</p>

<h5>其他:</h5><p>
第一次在git上发布自己的项目，由于我主要做后端开发，不擅长前端技术页面设计显得简陋不雅望请见谅。如有其它问题欢迎联系我，也欢迎其它做技术的朋友与我交流。
</p>
<div><b><i>作者email:gyqgoo@gmail.com。</i></b><div>
