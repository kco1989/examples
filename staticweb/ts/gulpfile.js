var gulp = require('gulp');
var browserify = require("browserify");
var source = require("vinyl-source-stream");
var tsify = require("tsify");
var paths = {
    pages: ['src/*.html']
};
var ts = require('gulp-typescript');
var tsProject = ts.createProject("tsconfig.json");
var dist = "dist";
gulp.task("test1", function () {
    return tsProject.src()
        .pipe(tsProject())
        .pipe(gulp.dest(dist));
});

gulp.task("copy-html", function () {
    return gulp.src(paths.pages)
        .pipe(gulp.dest(dist))
});

gulp.task("default", ['copy-html'], function () {
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
})

