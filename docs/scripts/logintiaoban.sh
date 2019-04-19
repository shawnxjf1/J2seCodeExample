#!/usr/bin/expect

## ssh  xujianfeng@118.126.103.152 -i /Users/shawn/xujianfeng.pem -p 50128
## 必须以 ./logintiaoban2.sh运行 不能以sh  logintiaoban2.sh运行（会出现spawn命令不存在）
set timeout 10

set user xujianfeng
set host 118.126.103.152
set password MtkSMWqala5uzV6m
set port 50128

spawn ssh $user@$host -i /Users/shawn/xujianfeng.pem -p $port
expect "*passphrase*"
send "$password\r"

interact
expect eof