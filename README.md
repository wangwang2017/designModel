# designModel
Java designModel
在使用git 对源代码进行push到gitHub时可能会出错，信息如下
　　此时很多人会尝试下面的命令把当前分支代码上传到master分支上。
　　$ git push -u origin master
　　但依然没能解决问题
　　出现错误的主要原因是github中的README.md文件不在本地代码目录中
　　可以通过如下命令进行代码合并【注：pull=fetch+merge]
　　git pull --rebase origin master
　　执行上面代码后可以看到本地代码库中多了README.md文件