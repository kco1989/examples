var gulp = require('gulp');
var browserify = require("browserify");
var source = require("vinyl-source-stream");
var watchify = require("watchify");
var gutil = require("gulp-util");
var tsify = require("tsify");
var uglify = require('gulp-uglify');
var sourcemaps = require('gulp-sourcemaps');
var buffer = require('vinyl-buffer');

var paths = {
    pages: ['src/*.html']
};
var ts = require('gulp-typescript');
var tsProject = ts.createProject("tsconfig.json");
var dist = "dist";
gulp.task("ts2js", function () {
    return tsProject.src()
        .pipe(tsProject())
        .pipe(gulp.dest(dist));
});

gulp.task("copy-html", function () {
    return gulp.src(paths.pages)
        .pipe(gulp.dest(dist))
});

gulp.task("bundle", ['copy-html'], function () {
    return browserify({
        basedir: '.',
        debug: true,
        entries: ['src/main.ts'],
        cache: {},
        packageCache: {}
    }).plugin(tsify)
        .bundle()
        .pipe(source("bundle.js"))
        .pipe(gulp.dest(dist));
});

var watchedBrowserify = watchify(browserify({
    basedir: '.',
    debug: true,
    entries: ['src/main.ts'],
    cache: {},
    packageCache: {}
}).plugin(tsify));

function bundle() {
    return watchedBrowserify.bundle()
        .pipe(source('bundle.js'))
        .pipe(gulp.dest(dist));
}

gulp.task('watchify', ['copy-html'], bundle);
watchedBrowserify.on('update', bundle);
watchedBrowserify.on('log', gutil.log);

gulp.task("uglify", ["copy-html"], function () {
    return browserify({
        basedir: '.',
        debug: true,
        entries: ['src/main.ts'],
        cache: {},
        packageCache: {}
    })
        .plugin(tsify)
        .bundle()
        .pipe(source('bundle.js'))
        .pipe(buffer())
        .pipe(sourcemaps.init({loadMaps: true}))
        .pipe(uglify())
        .pipe(sourcemaps.write('./'))
        .pipe(gulp.dest("dist"));
});


gulp.task('Babel', ['copy-html'], function () {
    return browserify({
        basedir: '.',
        debug: true,
        entries: ['src/main.ts'],
        cache: {},
        packageCache: {}
    })
        .plugin(tsify)
        .transform('babelify', {
            presets: ['es2015'],
            extensions: ['.ts']
        })
        .bundle()
        .pipe(source('bundle.js'))
        .pipe(buffer())
        .pipe(sourcemaps.init({loadMaps: true}))
        .pipe(sourcemaps.write('./'))
        .pipe(gulp.dest(dist));
});
gulp.task('default', ['watchify']);

