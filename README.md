# plugin-stackedit

集成 [StackEdit](https://github.com/benweet/stackedit) 到 Halo。

> 需要注意的是，StackEdit 并不支持在项目内直接集成，所以此插件是参考了 [stackedit.js](https://github.com/benweet/stackedit.js) 以 iframe 的方式集成。

## 开发环境

```bash
git clone git@github.com:halo-sigs/plugin-stackedit.git

# 或者当你 fork 之后

git clone git@github.com:{your_github_id}/plugin-stackedit.git
```

```bash
cd path/to/plugin-stackedit
```

```bash
# macOS / Linux
./gradlew pnpmInstall

# Windows
./gradlew.bat pnpmInstall
```

```bash
# macOS / Linux
./gradlew build

# Windows
./gradlew.bat build
```

修改 Halo 配置文件：

```yaml
halo:
  plugin:
    runtime-mode: development
    classes-directories:
      - "build/classes"
      - "build/resources"
    lib-directories:
      - "libs"
    fixedPluginPath:
      - "/path/to/plugin-stackedit"
```

## 使用方式

1. 在 [Releases](https://github.com/halo-sigs/plugin-stackedit/releases) 下载最新的 JAR 文件。
2. 在 Halo 后台的插件管理上传 JAR 文件进行安装。
3. 启动插件之后，即可在新建文章时选择此编辑器。
