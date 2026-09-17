# Documentación del ejercicio de ramas en GitHub

## Objetivo

Crear ramas remotas con los prefijos feature/, bugfix/ y hotfix/, publicar un archivo en cada una, integrar los cambios en main y actualizar las ramas.

## Alcance y método

Repositorio: [hrojasa1-art/Programacion2](https://github.com/hrojasa1-art/Programacion2). Rama principal: `main`.

Las operaciones se realizaron mediante la integración de GitHub: creación de referencias remotas, archivos y commits; integración mediante pull requests con merge; y sincronización mediante avance de referencias sin forzar.

Los comandos de esta guía son equivalentes para Git Bash. **No son una transcripción de comandos ejecutados en la computadora del estudiante.** Las evidencias reales son los commits y los pull requests enlazados. No se fabricaron capturas ni salidas de terminal.

Git no permite nombres de rama terminados en `/`; por eso se agregó `documentacion` a cada prefijo. Referencia: [reglas oficiales de nombres de Git](https://git-scm.com/docs/git-check-ref-format).

## Registro de creación y publicación

Las tres ramas se crearon desde el mismo commit inicial de main: [`5ae99dd340acd489ebef6aae012b0f4f34930db0`](https://github.com/hrojasa1-art/Programacion2/commit/5ae99dd340acd489ebef6aae012b0f4f34930db0).

| Rama | Archivo creado | Commit de creación | Integración |
| --- | --- | --- | --- |
| `feature/documentacion` | `README.md` | [`eee6bea`](https://github.com/hrojasa1-art/Programacion2/commit/eee6beac9cb1730ef04e591f914acd530482fe2b) | [PR #1](https://github.com/hrojasa1-art/Programacion2/pull/1) |
| `bugfix/documentacion` | `DocumentacionSolucion.txt` | [`5892778`](https://github.com/hrojasa1-art/Programacion2/commit/5892778c80a80c656835b59fcc4ebcbfcc05a49b) | [PR #2](https://github.com/hrojasa1-art/Programacion2/pull/2) |
| `hotfix/documentacion` | `DocumentacionSolucionhotfix.txt` | [`0121c20`](https://github.com/hrojasa1-art/Programacion2/commit/0121c2068c59fdd73a46b313b010e4924d46142d) | [PR #3](https://github.com/hrojasa1-art/Programacion2/pull/3) |

Cada archivo se publicó en su rama antes de integrarse. Los tres pull requests fueron fusionados con commits de merge, conservando la procedencia de los cambios:

- `feature/documentacion`: [`49b9b89`](https://github.com/hrojasa1-art/Programacion2/commit/49b9b89f22dde6f74207f4a9ac97d7d374a6b7e2).
- `bugfix/documentacion`: [`8f990e0`](https://github.com/hrojasa1-art/Programacion2/commit/8f990e01c070a2707de297cdd78a1ab7e4fa562e).
- `hotfix/documentacion`: [`4821c96`](https://github.com/hrojasa1-art/Programacion2/commit/4821c961e336546a7acd5c3203b8326ee55f3257).

La comparación entre la versión inicial y la integración de las tres ramas confirmó únicamente la adición de README.md, DocumentacionSolucion.txt y DocumentacionSolucionhotfix.txt. Los archivos Java se conservaron. Esta guía se agrega después como registro del ejercicio.

## Guía equivalente de creación local

Estos pasos explican cómo se realizaría la práctica desde el estado inicial. **No volver a ejecutarlos para recrear ramas que ya existen en este repositorio.** Para descargar el resultado terminado, usar la sección final.

En una copia local configurada con el remoto origin y sin cambios pendientes:

```bash
git checkout main
git pull --ff-only origin main
git checkout -b feature/documentacion
git push -u origin feature/documentacion
git checkout main
git checkout -b bugfix/documentacion
git push -u origin bugfix/documentacion
git checkout main
git checkout -b hotfix/documentacion
git push -u origin hotfix/documentacion
```

`checkout -b` crea una rama local y cambia a ella. `push -u` la publica y configura su seguimiento remoto. Volver a main antes de crear cada rama permite que compartan la misma base mientras main no cambie.

## Crear y publicar los archivos

En cada rama se crea el archivo con un editor, se guarda en la raíz del repositorio y se registra el cambio:

### feature/documentacion

```bash
git checkout feature/documentacion
# Crear y guardar README.md con un editor de texto.
git add README.md
git commit -m "docs: agregar README en feature/documentacion"
git push origin feature/documentacion
```

### bugfix/documentacion

```bash
git checkout bugfix/documentacion
# Crear y guardar DocumentacionSolucion.txt con un editor de texto.
git add DocumentacionSolucion.txt
git commit -m "docs: agregar DocumentacionSolucion.txt en bugfix/documentacion"
git push origin bugfix/documentacion
```

### hotfix/documentacion

```bash
git checkout hotfix/documentacion
# Crear y guardar DocumentacionSolucionhotfix.txt con un editor de texto.
git add DocumentacionSolucionhotfix.txt
git commit -m "docs: agregar DocumentacionSolucionhotfix.txt en hotfix/documentacion"
git push origin hotfix/documentacion
```

`git add` prepara el archivo, `git commit` registra una versión local y `git push` publica esa versión en GitHub. La práctica solo exige estos archivos documentales; no se afirma haber corregido un fallo funcional en Java.

## Integrar en main

La entrega real utiliza los tres pull requests enlazados. La alternativa local equivalente sería:

```bash
git checkout main
git pull --ff-only origin main
git merge --no-ff feature/documentacion -m "Integrar README desde feature"
git merge --no-ff bugfix/documentacion -m "Integrar documentacion bugfix"
git merge --no-ff hotfix/documentacion -m "Integrar documentacion hotfix"
git push origin main
```

`--no-ff` mantiene un commit de integración para distinguir cada rama en el historial. Al crear archivos con nombres diferentes, los cambios de esta práctica no compiten por el mismo contenido.

## Sincronizar las ramas

Tras publicar este registro en main, las referencias remotas de las tres ramas se actualizan al commit de main sin forzar el cambio. Esto es un avance rápido porque los commits originales de cada rama ya son antecesores de main. Las ramas se conservan para poder revisar la tarea.

El procedimiento local equivalente es:

```bash
git checkout feature/documentacion
git merge --ff-only main
git push origin feature/documentacion
git checkout bugfix/documentacion
git merge --ff-only main
git push origin bugfix/documentacion
git checkout hotfix/documentacion
git merge --ff-only main
git push origin hotfix/documentacion
git checkout main
```

## Verificación y evidencia para presentar

Se verifica que main y las tres ramas remotas apunten al mismo commit final y contengan los tres archivos solicitados más este registro. El historial conserva los commits de creación y los tres merges.

En GitHub se puede revisar:

- [Las ramas remotas](https://github.com/hrojasa1-art/Programacion2/branches).
- [Los archivos integrados en main](https://github.com/hrojasa1-art/Programacion2/tree/main).
- [El historial de commits](https://github.com/hrojasa1-art/Programacion2/commits/main).
- Los PR #1, #2 y #3 enlazados en la tabla.

Si se solicitan capturas, obtenerlas de esas pantallas o de una terminal real. Los comandos siguientes permiten comprobar el estado remoto desde una copia local:

```bash
git fetch origin
git branch -r
git ls-remote --heads origin main feature/documentacion bugfix/documentacion hotfix/documentacion
git log --oneline --graph --decorate --all
git diff --stat origin/main origin/feature/documentacion
git diff --stat origin/main origin/bugfix/documentacion
git diff --stat origin/main origin/hotfix/documentacion
```

Al finalizar esta práctica, ls-remote debe mostrar el mismo SHA para las cuatro ramas y los tres diff no deben mostrar diferencias. Cambios posteriores en el repositorio pueden modificar ese resultado.

## Descargar el resultado en la computadora

Si ya existe una copia local, abrir Git Bash dentro de esa carpeta. Revisar primero `git status`; guardar mediante commit o stash cualquier trabajo pendiente antes de cambiar de rama. Después:

```bash
git fetch origin
git checkout main
git pull --ff-only origin main
```

Si todavía no existen las tres ramas locales, crearlas siguiendo las remotas:

```bash
git checkout --track origin/feature/documentacion
git checkout --track origin/bugfix/documentacion
git checkout --track origin/hotfix/documentacion
git checkout main
```

Si una rama local ya existe, cambiar a ella con `git checkout nombre-de-rama` y actualizar con `git pull --ff-only origin nombre-de-rama`. Si Git indica que las historias divergieron, revisar los commits antes de intentar integrarlos.
