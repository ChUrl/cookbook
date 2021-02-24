module.exports = {
    purge: {
        // Should contain every file that references used css classes
        content: ['./src/main/resources/**/*.html'],

        // !: Tailwind only purges when NODE_ENV is set to production
    },
    theme: {
        extend: {}
    },
    variants: {
        extend: {}
    },
    plugins: []
}
