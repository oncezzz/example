### spring shell 基于spring开发shell程序

* @ShellComponent 标注为一个shell command
* @ShellCommandGroup 标注为一个shell command,同时可设置命令的分组
* @ShellMethod 标注为一个可执行的shell命令
* @ShellMethodAvailability 标注一个方法,判断其他同组command是否可执行
* @ShellOption 标注方法参数,别名等参数注入